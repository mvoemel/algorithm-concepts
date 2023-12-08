from functools import reduce

def hamming_syndrome(bits):
    return reduce(
        # Reduce by XOR
        lambda x, y: x ^ y,
        # All indices of active bits
        [i for (i, b) in enumerate(bits) if b]
    )