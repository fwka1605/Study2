import numpy as np

np.random.seed(0)

def make_image(m,n):
    image = np.random.randint(0,6,(m,n))
    return image

def change_little(matrix):
    shape = matrix.shape

    for i in range(shape[0]):
        for j in range(shape[1]):
            if np.random.randint(0,2)==1:
                matrix[i,j]=np.random.randint(0,6,1)

    return matrix

image1 = make_image(3,3)

print(image1)
print()

image2 = change_little(image1.copy())

print(image2)
print()

image3 = image2-image1

print(image3)
print()

image3 = np.abs(image3)
print(image3)
print()
