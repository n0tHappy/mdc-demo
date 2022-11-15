package com.n0thappy.mdc.util;

import org.springframework.util.StringUtils;
import java.util.UUID;

/**
 * @date 2022/11/14 3:43 下午
 */
public class LogTraceGenerator {
    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    private static final String TIE = "-";
    private static final int SHORT_TRACE_ID_LENGTH = 8;

    private LogTraceGenerator() {
    }

    /**
     * 全长32位UUID作为trace id
     *
     * @return 32位uuid
     */
    public static String genTraceId() {
        return UUID.randomUUID().toString().replaceAll(TIE, "");
    }

    /**
     * 生成短8位uuid,当父追踪不为空时，进行拼接，适用于异步任务
     * @param parentTraceId 上级追踪id
     * @return 追踪id
     */
    public static String generateShortUuid(String parentTraceId) {
        StringBuilder shortBuffer = StringUtils.isEmpty(parentTraceId) ? new StringBuilder() : new StringBuilder(parentTraceId + TIE);
        String uuid = genTraceId();
        for (int i = 0; i < SHORT_TRACE_ID_LENGTH; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

}
