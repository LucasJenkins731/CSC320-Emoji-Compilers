# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 0.0
STR1:    .asciz "Array access test completed"
IDXarr:    .double 0.0
IDXmat:    .double 0.0
IDXval2:    .double 0.0
IDXval1:    .double 0.0
IDXi:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXi
    fsd fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    # TODO: 1D array access arr[i]
    la t0,IDXval1
    fsd fa0,(t0)
    la t0,IDXi
    fld ft2,(t0)
    la t0,IDXi
    fld ft3,(t0)
    # TODO: 2D array access mat[i][j]
    la t0,IDXval2
    fsd fa0,(t0)
    la    a0, STR1
    li    a7, 4
    ecall
end:
    li    a0, 0
    li    a7, 93
    ecall
