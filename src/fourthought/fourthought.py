def get_result(expression):
    arr = expression.split()

    # First pass: handle * and /
    values = []
    operators = []

    i = 0
    while i < len(arr):
        if i % 2 == 0:
            values.append(int(arr[i]))
        else:
            operator = arr[i]
            if operator == '*' or operator == '/':
                left = values.pop()
                right = int(arr[i + 1])
                if operator == '*':
                    values.append(left * right)
                else:
                    values.append(left // right)
                i += 1
            else:
                operators.append(operator)
                values.append(int(arr[i + 1]))
                i += 1
        i += 1

    # Second pass: handle + and -
    result = values.pop(0)
    for operator in operators:
        operand = values.pop(0)
        if operator == '+':
            result += operand
        else:
            result -= operand

    return result


def fourthought():
    OPERANDS = ['*', '-', '+', '/']
    NUMBER = 4

    n = int(input())

    map = {}
    for i in range(len(OPERANDS)):
        for j in range(len(OPERANDS)):
            for k in range(len(OPERANDS)):
                expression = f"{NUMBER} {OPERANDS[i]} {NUMBER} {OPERANDS[j]} {NUMBER} {OPERANDS[k]} {NUMBER}"
                result = get_result(expression)
                expression = f"{expression} = {result}"
                if result not in map:
                    map[result] = expression

    for _ in range(n):
        query = int(input())
        print(map.get(query, "no solution"))



fourthought()
