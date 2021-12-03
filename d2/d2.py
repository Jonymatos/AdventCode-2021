def position(inp, WithAim):
    horizontal, depth, aim = 0, 0, 0
    for step in inp:
        command, units = step[0], eval(step[1])

        if command == 'forward':
            horizontal += units
            depth += units * aim

        elif command == 'up':
            depth -= units * int(not WithAim)
            aim -= units * int(WithAim)

        elif command == 'down':
            depth += units * int(not WithAim)
            aim += units * int(WithAim)
            
    return horizontal * depth

file = open("input2.txt", "r")
inp = [num.split() for num in file.readlines()]
file.close()
print(position(inp, False)) #Part1
print(position(inp, True)) #Part2