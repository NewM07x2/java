package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OsTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void winTest() {
        System.out.println("このテストはWindows環境で実行されます");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void macTest() {
        System.out.println("このテストはMac OS環境で実行されます");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    public void linuxTest() {
        System.out.println("このテストはLinux環境で実行されます");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void disabledWinTest() {
        System.out.println("このテストはWindows環境では実行されません");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    public void disabledMacTest() {
        System.out.println("このテストはMac OS環境では実行されません");
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    public void disabledLinuxTest() {
        System.out.println("このテストはLinux環境では実行されません");
    }
}
