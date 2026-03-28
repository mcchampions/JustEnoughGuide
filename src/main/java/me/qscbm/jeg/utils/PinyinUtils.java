package me.qscbm.jeg.utils;

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class PinyinUtils {
    public static ConcurrentHashMap<String, String> PINYIN_MAP = new ConcurrentHashMap<>();

    public static void load() {
        List<SlimefunItem> items = Slimefun.getRegistry().getAllSlimefunItems();
        PINYIN_MAP = new ConcurrentHashMap<>(items.size() + 50);
        for (SlimefunItem item : items) {
            String name = ChatColor.stripColor(item.getItemName()).toLowerCase(Locale.ROOT);
            String pinyin = PinyinHelper.toPinyin(name, PinyinStyleEnum.FIRST_LETTER, "");
            PINYIN_MAP.put(name, pinyin);
        }
    }

    public static String getPinyin(String string) {
        String pinyin = PINYIN_MAP.get(string);
        if (pinyin == null) {
            String py = PinyinHelper.toPinyin(string, PinyinStyleEnum.FIRST_LETTER, "");
            PINYIN_MAP.put(string, py);
            return py;
        }
        return pinyin;
    }
}
