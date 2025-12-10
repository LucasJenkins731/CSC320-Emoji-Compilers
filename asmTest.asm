# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
input_buffer: .space 100
VAL0:    .double 1.0
VAL1:    .double 2.0
IDXx:    .double 0.0
IDXy:    .double 0.0
    .text
main: 
    la t0,VAL0
    fld fa0,(t0)
    la t0,IDXx
    fsd fa0,(t0)
    la t0,VAL1
    fld fa0,(t0)
    la t0,IDXy
    fsd fa0,(t0)
end:
    li    a0, 0
    li    a7, 93
    ecall
