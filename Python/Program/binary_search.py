def binary_search(numbers,target_number):
    
    low = 0

    hight = len(numbers)

    while low <= hight:
        middle = (low+hight)//2

        if(numbers[middle]==target_number):
            print("{0}は{1}番目にあります。".format(target_number,middle))
            break
        elif(numbers[middle]<target_number):
            low = middle+1
        else:
            hight = middle-1
            hight = middle-1



numbers = [1,2,3,4,5,6,7,8,9,10,11,12,13]

target_number = 11

binary_search(numbers,target_number)

