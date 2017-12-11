
###########Q for quit, hold e to snap a picture and get access
import tkinter as tk
import argparse
import datetime
import cv2
import os
import face_recognition

failure_max = 5
matched = 0
passwords = [('cj', 'cw'), ('dad', 'dad'), ('mom', 'mom')]

user1 = "string"
def make_entry(parent, caption, width=None, **options):
    tk.Label(parent, text=caption).pack(side=tk.TOP)
    entry = tk.Entry(parent, **options)
    if width:
        entry.config(width=width)
    entry.pack(side=tk.TOP, padx=10, fill=tk.BOTH)
    return entry


def enter(event):
    check_password()


def check_password(failures=[]):
    """ Collect 1's for every failure and quit program in case of failure_max failures """
    ref_name = user.get()
    print(user1, password.get())
    if (user.get(), password.get()) in passwords:
        root.destroy()
        print('Logged in')

        video_capture = cv2.VideoCapture(0)

         # Load a sample picture and learn how to recognize it.
        ref_image = face_recognition.load_image_file("/Users/cjlaptop/Desktop/" + ref_name + ".jpg")
        ref_face_encoding = face_recognition.face_encodings(ref_image)[0]
        [0]

        # Initialize some variables
        face_locations = []
        face_encodings = []
        face_names = []
        process_this_frame = True

        while True:
            # Grab a single frame of video
            ret, frame = video_capture.read()

            # Resize frame of video to 1/4 size for faster face recognition processing
            small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)

            # Only process every other frame of video to save time
            if process_this_frame:
                # Find all the faces and face encodings in the current frame of video
                face_locations = face_recognition.face_locations(small_frame)
                face_encodings = face_recognition.face_encodings(small_frame, face_locations)

                face_names = []
                for face_encoding in face_encodings:
                    # See if the face is a match for the known face(s)
                    match = face_recognition.compare_faces([ref_face_encoding], face_encoding)
                    name = "Unknown"

                    if match[0]:
                        name = ref_name
                        global matched
                        matched = 1


                    face_names.append(name)


            process_this_frame = not process_this_frame



            # Display the results
            for (top, right, bottom, left), name in zip(face_locations, face_names):
                # Scale back up face locations since the frame we detected in was scaled to 1/4 size
                top *= 4
                right *= 4
                bottom *= 4
                left *= 4

                # Draw a box around the face
                cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)

                # Draw a label with a name below the face
                cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
                font = cv2.FONT_HERSHEY_DUPLEX
                cv2.putText(frame, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
            if cv2.waitKey(1) & 0xFF == ord('e'):
                do_process()
            #Display the resulting image
            cv2.imshow('Video', frame)




            # Hit 'q' on the keyboard to quit!

            if cv2.waitKey(0) & 0xFF == ord('q'):
                break

        return

    failures.append(1)
    if sum(failures) >= failure_max:
        root.destroy()
        raise SystemExit('Locked out!')
    else:
        root.title('Try again. Attempt %i/%i' % (sum(failures) + 1, failure_max))


#make a text file if both login and face recognition work
def do_process():
    print("Access granted!")
if cv2.waitKey(1) & 0xFF == ord('w') & matched == 1:
    do_process()



root = tk.Tk()
root.geometry('800x600')
root.title('Enter your information')
# frame for window margin
parent = tk.Frame(root, padx=10, pady=10)
parent.pack(fill=tk.BOTH, expand=True)
# entrys with not shown text
user = make_entry(parent, "User name:", 16, show='*')
password = make_entry(parent, "Password:", 16, show="*")
# button to attempt to login
b = tk.Button(parent, borderwidth=4, text="Login", width=10, pady=8, command=check_password)
b.pack(side=tk.BOTTOM)
password.bind('<Return>', enter)
user.focus_set()
parent.mainloop()
