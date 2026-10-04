# shape area functions

import math

def circle_area(radius: float, unused=None) -> float:
    return math.pi * radius ** 2

def rectangle_area(width: float, height: float) -> float:
    return width * height

def triangle_area(base: float, height: float) -> float:
    return base * height * 0.5