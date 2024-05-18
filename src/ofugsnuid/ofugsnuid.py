def ofugsnuid() -> None:
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(int(input()))

    for i in range(n - 1, -1, -1):
        print(arr[i])

ofugsnuid()
