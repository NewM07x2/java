package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    @Test
    public void test1() {
        System.out.println("テスト1 実行");
    }

    @Test
    public void test2() {
        System.out.println("テスト2 実行");
    }

    @Test
    public void test3() {
        System.out.println("テスト3 実行");
    }

    @Nested
    public class Nest1 {

        @Test
        public void test1() {
            System.out.println("[ Nest1 ] テスト1 実行");
        }

        @Test
        public void test2() {
            System.out.println("[ Nest1 ] テスト2 実行");
        }

    }
}
