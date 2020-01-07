'''
Task
You are given a rectangular floor that is to be paved with square tiles.The tiles all have special sizes:  They have dimensions x foot by 
x foot, where x is a power of 2: 1, 2, 4, 8,....  A 5 foot x 6 foot rectangle could be paved with 30 tiles of dimension 1 x 1, however, we
only need 9 tiles, if we use one 4x4, two 2x2 and 6 1x1 tiles. Write a program that will find the minimum number of tiles needed to pave the
floor, given its dimensions.

Sample input:
10 5
1000 1001
21 13
99999 888
345 1277

Sample output:
14 tiles are needed for a 10 by 5 floor
1358 tiles are needed for a 1000 by 1001 floor
42 tiles are needed for a 21 by 13 floor
4065 tilesare needed for a 9999 by 8888 floor
2046 tiles are needed for a 345 by 1277 floor

'''


from math import floor, log10

def count_squares(length, width):
    if length == 0 or width == 0:
        return 0
        
    min_side = min(length, width)
    power = floor(log10(min_side) / log10(2))
    tile_length = 2 ** power
    max_side = max(length, width)
    a = max_side // tile_length
    b = max_side % tile_length
    c = min_side % tile_length

    return a + count_squares(b, tile_length) + count_squares(a * tile_length, c) + count_squares(b, c)


s1, s2 = map(int, input().split())
print(f"{count_squares(s1, s2)} tiles are needed for a {s1} by {s2} floor.")
