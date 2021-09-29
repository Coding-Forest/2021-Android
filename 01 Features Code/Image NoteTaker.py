import cv2  
from google.colab.patches import cv2_imshow
import matplotlib.pyplot as plt

import os 
from google.colab import drive
drive.mount('here')

class NoteTaker:

    ROOT_DIR = "/content/here/MyDrive/Android/"
    CHILD_DIRS = ["UI", "Java"]
    parent_dir = ""
    java_path = ""
    ui_path = ""

    def __init__(self, learn_topic):
        self.ui_path = self.ROOT_DIR + learn_topic + "/" + self.CHILD_DIRS[0] + "/"
        self.java_path = self.ROOT_DIR + learn_topic + "/" + self.CHILD_DIRS[1] + "/"


    def set_dirs(self):
        os.chdir(self.ROOT_DIR)
        os.makedirs(self.ROOT_DIR + self.parent_dir)
        for CHILD_DIR in self.CHILD_DIRS:
            os.makedirs(self.ROOT_DIR + self.parent_dir + CHILD_DIR)


    def list_files(self):
        list_UI = os.listdir(self.ui_path)
        list_Java = os.listdir(self.java_path)

        return list_UI, list_Java

    
    def get_script(self):
        list_UI, list_Java = self.list_files()

        for item in list_UI:
            print(f'path = "{self.ui_path + item}"')
            print('nt.show_img(path)')
        
        print('')
        for item in list_Java:
            print(f'path = "{self.java_path + item}"')
            print('nt.show_img(path)')
    

    def show_img(self, path, cvtColor=False):
        img = cv2.imread(path)
        if (cvtColor == True):
            img = cv2.cvtColor(img, cv2.COLOR_RGB2BGR)
        cv2_imshow(img)


    def get_img(self, path, cvtColor=False):
        img = cv2.imread(path)
        if(cvtColor == True):
            img = cv2.cvtColor(img, cv2.COLOR_RGB2BGR)
        return img  
