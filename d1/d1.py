def count(lst, wd):
    count=0
    for i in range(wd, len(lst)):
        if sum(lst[i-wd+1:i+1]) > sum(lst[i-wd:i]):
            count+=1
    return count


file = open("input1.txt", "r")
list = [eval(num) for num in file.readlines()]
file.close()
print(count(list,1))
print(count(list,3))