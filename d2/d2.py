def count(WithAim):
    horizontal=0
    depth=0
    aim=0
    file = open("input2.txt", "r")
    while True:
        line = file.readline()
        step = line.split()
        if len(line) == 0:
            break
        units = eval(step[1])
        if step[0] == 'forward':
            horizontal += units
            depth += units * aim
        elif step[0] == 'up':
            depth -= units * int(not WithAim)
            aim -= units * int(WithAim)
        elif step[0] == 'down':
            depth += units * int(not WithAim)
            aim += units * int(WithAim)
    file.close()
    return horizontal*depth

print(count(False)) #Part1
print(count(True)) #Part2