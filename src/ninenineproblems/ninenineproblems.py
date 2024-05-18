def ninenineproblems():
    number_str = input()
    if len(number_str) == 2 or len(number_str) == 1:
        print(99)
    else:
        number = int(number_str)
        front_str = number_str[:-2]
        end_str = front_str + "99"
        num_end = int(end_str)
        first_int = num_end - 100
        
        diff_one = abs(number - num_end)
        diff_two = abs(number - first_int)
        if diff_two < diff_one:
            print(first_int)
        else:
            print(num_end)

ninenineproblems()
