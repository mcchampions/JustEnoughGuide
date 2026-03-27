/*
 * Copyright (c) 2024-2026 balugaq
 *
 * This file is part of JustEnoughGuide, available under MIT license.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * - The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 * - The author's name (balugaq or 大香蕉) and project name (JustEnoughGuide or JEG) shall not be
 *   removed or altered from any source distribution or documentation.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.balugaq.jeg.api.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jspecify.annotations.NullMarked;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;

/**
 * This annotation is used to indicate that a class should not be displayed in the cheat mode menu. Priority higher than
 * {@link DisplayInCheatMode}
 * <p>
 * Usage:
 * <p>
 * &#064;NotDisplayInCheatMode public class MyGroup extends ItemGroup { //... }
 *
 * @author balugaq
 * @since 1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@NullMarked
public @interface NotDisplayInCheatMode {
    /**
     * @author balugaq
     * @since 1.8
     */
    @NullMarked
    class Checker {
        public static boolean contains(ItemGroup group) {
            String namespace = group.getKey().getNamespace();
            String key = group.getKey().getKey();
            String className = group.getClass().getName();

            // @formatter:off
            return "io.github.sefiraat.networks.slimefun.groups.DummyItemGroup".equals(className)||className.startsWith("com.balugaq.netex.api.groups")||className.startsWith("io.github.ytdd9527.mobengineering.implementation.slimefun.groups")||className.startsWith("io.taraxacum.finaltech.core.group")||"me.lucasgithuber.obsidianexpansion.utils.ObsidianForgeGroup".equals(className)||"me.char321.nexcavate.slimefun.NEItemGroup".equals(className)||"io.github.mooy1.infinityexpansion.categories.InfinityGroup".equals(className)||"io.github.mooy1.infinityexpansion.infinitylib.groups.SubGroup".equals(className)||"me.lucasgithuber.obsidianexpansion.infinitylib.groups.SubGroup".equals(className)||"io.github.slimefunguguproject.bump.implementation.groups.AppraiseInfoGroup".equals(className)||"dev.sefiraat.netheopoiesis.implementation.groups.DummyItemGroup".equals(className)||"io.github.addoncommunity.galactifun.infinitylib.groups.SubGroup".equals(className)||"io.github.sefiraat.crystamaehistoria.slimefun.itemgroups.DummyItemGroup".equals(className)||"io.github.slimefunguguproject.bump.libs.sefilib.slimefun.itemgroup.DummyItemGroup".equals(
                            className)||"me.voper.slimeframe.implementation.groups.ChildGroup".equals(className)||"me.voper.slimeframe.implementation.groups.MasterGroup".equals(className)||"io.github.sefiraat.emctech.slimefun.groups.DummyItemGroup".equals(className)||"dev.sefiraat.sefilib.slimefun.itemgroup.DummyItemGroup".equals(className)||"nexcavate".equals(namespace)&&"dummy".equals(key)||"slimefun".equals(namespace)&&"rick".equals(key)||group instanceof SubItemGroup&&"networks".equals(namespace)&&key.startsWith("ntw_expansion_")||"mobengineering".equals(namespace)&&(key.startsWith("mod_engineering_")||key.startsWith("mob_engineering_"))||"finaltech-changed".equals(namespace)&&key.startsWith("_finaltech_")||"finaltech".equals(namespace)&&key.startsWith("finaltech_")||"danktech2".equals(namespace);
            // @formatter:on
        }
    }
}
