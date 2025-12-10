# =================================
# Auto-generated code. Do not edit.
# =================================
    .data
VAL0:    .double 1.0
VAL1:    .double 2.0
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
