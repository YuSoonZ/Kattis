import array

def electionparadox():
    n = int(input())
    input_line = input()
    str_num = input_line.split(' ')
    numbers_array = array.array('i', [int(num.strip()) for num in str_num])

    sorted_numbers = sorted(numbers_array, reverse=True)
    max_win = n // 2
    result = 0
    for i in range(n):
        if i < max_win:
            result += sorted_numbers[i]
        else:
            temp = sorted_numbers[i]
            result += (temp // 2)

    print(result)

electionparadox()
        
    
            
