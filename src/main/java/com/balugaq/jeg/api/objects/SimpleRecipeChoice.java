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

package com.balugaq.jeg.api.objects;

import java.util.*;
import java.util.function.Predicate;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NullMarked;

import com.balugaq.jeg.utils.StackUtils;

/**
 * @author balugaq
 * @since 1.9
 */
@SuppressWarnings("unused")
@NullMarked
public class SimpleRecipeChoice implements RecipeChoice {
    private List<ItemStack> choices;
    private Predicate<ItemStack> predicate = null;

    public SimpleRecipeChoice(ItemStack stack) {
        this(List.of(stack));
    }

    public SimpleRecipeChoice(ItemStack... stacks) {
        this(Arrays.asList(stacks));
    }

    public SimpleRecipeChoice(List<ItemStack> choices) {
        this.choices = new ArrayList<>(choices);
    }

    /** @deprecated */
    @Deprecated(
            since = "1.13.1"
    )
    public ItemStack getItemStack() {
        return this.choices.get(0).clone();
    }

    public List<ItemStack> getChoices() {
        return Collections.unmodifiableList(this.choices);
    }

    public SimpleRecipeChoice clone() {
        try {
            SimpleRecipeChoice clone = (SimpleRecipeChoice)super.clone();
            clone.choices = new ArrayList<>(this.choices.size());

            for (ItemStack choice : this.choices) {
                clone.choices.add(choice.clone());
            }

            return clone;
        } catch (CloneNotSupportedException var4) {
            throw new AssertionError(var4);
        }
    }

    public @Nullable Predicate<ItemStack> getPredicate() {
        return this.predicate;
    }

    public void setPredicate(@Nullable Predicate<ItemStack> predicate) {
        this.predicate = predicate;
    }

    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.choices);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            SimpleRecipeChoice other = (SimpleRecipeChoice)obj;
            return Objects.equals(this.choices, other.choices);
        }
    }

    public String toString() {
        return "SimpleRecipeChoice{choices=" + this.choices + "}";
    }

    public RecipeChoice validate(boolean allowEmptyRecipes) {
        if (this.choices.stream().anyMatch((s) -> s.getType().isAir())) {
            throw new IllegalArgumentException("SimpleRecipeChoice cannot contain air");
        } else {
            return this;
        }
    }

    public boolean test(ItemStack other) {
        for (ItemStack choice : this.getChoices()) {
            if (StackUtils.itemsMatch(choice, other, true, false)) {
                return true;
            }
        }

        return false;
    }
}
