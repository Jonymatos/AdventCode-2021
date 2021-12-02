def count(inp, WithAim):
    horizontal, depth, aim = 0, 0, 0
    for step in inp:
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
            
    return horizontal*depth

file = open("input2.txt", "r")
inp = [num.split() for num in file.readlines()]
file.close()
print(count(inp, False)) #Part1
print(count(inp, True)) #Part2