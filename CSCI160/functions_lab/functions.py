'''
File: functions.py
Author: Alex Burdick
Date: 10/26/2025
'''

import math

def distance(x1: float, y1: float, x2: float, y2: float) -> float:
    return math.sqrt( (x2-x1)**2 + (y2-y1)**2 )

def line_length(x1: float, y1: float, x2: float, y2: float) -> float:
    return distance(x1, y1, x2, y2)

def radius(x1: float, y1: float, x2: float, y2: float) -> float:
    return distance(x1, y1, x2, y2)