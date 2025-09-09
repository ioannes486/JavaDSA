N = int(input())
arr = list(map(int, input().split()))
add_num, sub_num, mul_num, div_num = map(int, input().split())

min_num = 1000000000
max_num = -1000000000


def calculate(idx, number, add_num, sub_num, mul_num, div_num):
    global max_num, min_num
    if add_num == sub_num == mul_num == div_num == 0:
        max_num = max(number, max_num)
        min_num = min(number, min_num)
        return

    if add_num > 0:
        calculate(idx + 1, number + arr[idx+1], add_num-1, sub_num, mul_num, div_num)


    if sub_num > 0:
        calculate(idx + 1, number - arr[idx+1], add_num, sub_num-1, mul_num, div_num)


    if mul_num > 0:
        calculate(idx + 1, number * arr[idx+1], add_num, sub_num, mul_num-1, div_num)


    if div_num > 0:
        if number >= 0:
            calculate(idx + 1, number // arr[idx+1], add_num, sub_num, mul_num, div_num-1)
        else:
            calculate(idx + 1, -1*((-1 * number) // arr[idx + 1]), add_num, sub_num, mul_num, div_num - 1)


calculate(0, arr[0], add_num, sub_num, mul_num, div_num)



print(max_num)
print(min_num)