package com.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaxAmountServiceTest {

    @Test
    @DisplayName("消費税率8%で端数切捨ての場合")
    void test1() {

    }

    @Test
    @DisplayName("消費税率8%で端数切り上げの場合")
    void test2() {
//        // スタブの設定(doReturnを使用)
//        doReturn(BigDecimal.valueOf(8)).when(taxService).getTaxRate(any());
//        var taxAmount = taxAmountService.getTaxAmount(107, LocalDate.of(2019, 9, 30));
//        // 戻り値の検査
//        assertEquals(9, taxAmount);
//
//        verify(taxService).getTaxRate(dateCaptor.capture());
//
//        assertEquals(LocalDate.of(2019, 9, 30), dateCaptor.getValue());
    }

    @Test
    @DisplayName("消費税率10%の場合")
    void test3() {
//        // スタブの設定
//        when(taxService.getTaxRate(any())).thenReturn(BigDecimal.TEN);
//        var taxAmount = taxAmountService.getTaxAmount(105, LocalDate.of(2019, 10, 1));
//        // 戻り値の検査
//        assertEquals(11, taxAmount);
    }

    @Test
    @DisplayName("課税対象額が0の場合")
    void test4() {
//        var taxAmount = taxAmountService.getTaxAmount(0, LocalDate.of(2019, 9, 30));
//        // 戻り値の検査
//        assertEquals(0, taxAmount);
//        // taxServiceの呼び出し回数の検査(課税対象額が0の場合は呼び出されていないはず)
//        verify(taxService, never()).getTaxRate(any());
    }
}
