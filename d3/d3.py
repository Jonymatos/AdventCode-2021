def get_bit(nums, ind):
    count0 = count1 = 0

    for j in range(len(nums)):
        if nums[j][ind] == '0':
            count0 += 1 
        else:
            count1 += 1
        
    bit = 0 if count0 > count1 else 1
    return bit

def str_bin_to_decimal(str_bin):
    num, exp = 0, len(str_bin)-1
    for bit in str_bin:
        num += (2**exp) * eval(bit)
        exp -= 1
    return num

def gamma_rate(nums):
    str_num = ''
    n_bits = len(nums[0])

    for i in range(n_bits):
        str_num += str(get_bit(nums, i))

    result = str_bin_to_decimal(str_num)
    return ((2**n_bits) - result - 1) * result

def oxygen_rate(nums, scrumber):
    n_bits = len(nums[0])

    for i in range(n_bits):
        if len(nums) == 1:
            return nums[0]

        choosen_bit = get_bit(nums, i)
        if scrumber:
            choosen_bit = int(not bool(choosen_bit))

        nums = list(filter(lambda x: (x[i] == str(choosen_bit)), nums))

    return nums[0]
      

def life_rate(nums):
    return str_bin_to_decimal(oxygen_rate(nums, False)) * str_bin_to_decimal(oxygen_rate(nums, True))

file = open("input3.txt", "r")
inp = [num.rstrip('\n') for num in file.readlines()]
file.close()
print(gamma_rate(inp)) #Part1
print(life_rate(inp)) #Part2