package com.ahxinin.adt;

/**
 * @description: 复数计算
 * @date : 2023-05-28
 */
public interface ComplexCalculate {

    ComplexNumber assign(float real, float image);
    ComplexNumber add(ComplexNumber a, ComplexNumber b);
    ComplexNumber minus(ComplexNumber a, ComplexNumber b);
    ComplexNumber multiply(ComplexNumber a, ComplexNumber b);
    ComplexNumber divide(ComplexNumber a, ComplexNumber b);
}
