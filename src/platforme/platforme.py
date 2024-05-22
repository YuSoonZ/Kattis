class Platform:
    def __init__(self, height, x1, x2):
        self.height = height
        self.x1 = x1
        self.x2 = x2

def platforme():
    n = int(input())
    arr = []

    for _ in range(n):
        height, x1, x2 = map(int, input().split())
        arr.append(Platform(height, x1, x2))

    arr.sort(key=lambda platform: platform.height)

    result = 0
    for i, platform in enumerate(arr):
        height = platform.height
        x1 = platform.x1
        x2 = platform.x2

        if i == 0:
            result += (height * 2)
        else:
            left_leg = height
            right_leg = height

            for j in range(i - 1, -1, -1):
                left_check = arr[j]
                height_j = left_check.height
                x1_j = left_check.x1
                x2_j = left_check.x2

                if x1 + 0.5 >= x1_j and x1 + 0.5 <= x2_j:
                    left_leg -= height_j
                    break

            for k in range(i - 1, -1, -1):
                right_check = arr[k]
                height_k = right_check.height
                x1_k = right_check.x1
                x2_k = right_check.x2

                if x2 - 0.5 >= x1_k and x2 - 0.5 <= x2_k:
                    right_leg -= height_k
                    break
            result += (left_leg + right_leg)

    print(result)

platforme()
