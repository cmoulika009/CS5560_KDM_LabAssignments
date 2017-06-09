__author__ = "Moulika Chadalavada"

import PIL.Image as Image

img=Image.open("tulips.jpg")
print(img.size)
print(img.format)

area=(200,200,400,575)
cropped_img= img.crop(area)

img.show()
cropped_img.show()