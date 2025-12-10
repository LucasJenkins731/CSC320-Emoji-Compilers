# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
VAL1:    .double 0.0
VAL2:    .double 1.0
VAL3:    .double 0.0
VAL4:    .double 1.0
VAL5:    .double 2.0
VAL6:    .double 0.0
VAL7:    .double 2.0
VAL8:    .double 3.0
VAL9:    .double 1.0
VAL10:    .double 0.0
VAL11:    .double 4.0
VAL12:    .double 1.0
VAL13:    .double 1.0
VAL14:    .double 5.0
VAL15:    .double 1.0
VAL16:    .double 2.0
VAL17:    .double 6.0
STR18:    .asciz "Matrix[0][0] = "
VAL19:    .double 0.0
VAL20:    .double 0.0
STR21:    .asciz "Matrix[1][2] = "
VAL22:    .double 1.0
VAL23:    .double 2.0
IDXmatrix:    .space 48
    .text
main: 
    la t0,VAL0
    fld ft2,(t0)
    la t0,VAL1
    fld ft3,(t0)
    la t0,VAL2
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL3
    fld ft2,(t0)
    la t0,VAL4
    fld ft3,(t0)
    la t0,VAL5
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL6
    fld ft2,(t0)
    la t0,VAL7
    fld ft3,(t0)
    la t0,VAL8
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL9
    fld ft2,(t0)
    la t0,VAL10
    fld ft3,(t0)
    la t0,VAL11
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL12
    fld ft2,(t0)
    la t0,VAL13
    fld ft3,(t0)
    la t0,VAL14
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la t0,VAL15
    fld ft2,(t0)
    la t0,VAL16
    fld ft3,(t0)
    la t0,VAL17
    fld fa0,(t0)
    # Store 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fsd fa0, (t0)   # Store element
    la    a0, STR18
    li    a7, 4
    ecall
    la t0,VAL19
    fld ft2,(t0)
    la t0,VAL20
    fld ft3,(t0)
    # Load 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
    la    a0, STR21
    li    a7, 4
    ecall
    la t0,VAL22
    fld ft2,(t0)
    la t0,VAL23
    fld ft3,(t0)
    # Load 2D array element matrix[ft2][ft3]
    fcvt.w.d t0, ft2  # Convert row index to int
    fcvt.w.d t1, ft3  # Convert col index to int
    li t2, 2           # Number of columns
    mul t0, t0, t2              # row * cols
    add t0, t0, t1              # row * cols + col
    li t1, 8                    # Size of double
    mul t0, t0, t1              # Calculate offset
    la t1, IDXmatrix  # Load array base address
    add t0, t1, t0              # Add offset to base
    fld fa0, (t0)   # Load element
    li    a7, 3
    ecall
    li    a0, 10
    li    a7, 11
    ecall
end:
    li    a0, 0
    li    a7, 93
    ecall
