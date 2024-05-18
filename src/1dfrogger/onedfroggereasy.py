def frogger():
    magic = "magic"
    left = "left"
    right = "right"
    cycle = "cycle"

    first = input().split()
    n = int(first[0])
    s = int(first[1]) - 1
    m = int(first[2])
        
    array = input().split()
    int_array = []
    for x in array:
        int_array.append(int(x))

    hops = 0
    hashset = set()
    curr_pos = s

    while True:
        if int_array[curr_pos] == m:
            print(magic)
            print(hops)
            break
        elif int_array[curr_pos] + curr_pos >= n:
            print(right)
            hops += 1
            print(hops)
            break
        elif int_array[curr_pos] + curr_pos < 0:
            print(left)
            hops += 1
            print(hops)
            break
        elif int_array[curr_pos] + curr_pos in hashset:
            print(cycle)
            hops += 1
            print(hops)
            break
        else:
            hashset.add(curr_pos)
            hops += 1
            curr_pos += int_array[curr_pos]

frogger()
