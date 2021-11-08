package net.Encryptar.IndustrialExpansion.common.enchantments;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Vampiric extends net.minecraft.world.item.enchantment.Enchantment {
    public Vampiric(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
    }

    @Override
    public int getMaxLevel(){
        return 1;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        attacker.heal(0.5F);
    }

    @Override
    public boolean canEnchant(ItemStack p_44642_) {
        return p_44642_.getItem() instanceof AxeItem ? true : super.canEnchant(p_44642_) || p_44642_.getItem() instanceof SwordItem ? true : super.canEnchant(p_44642_);
    }
    @Override
    public boolean isTreasureOnly(){
        return true;
    }

    @Override
    public boolean isTradeable(){
        return true;
    }

    @Override
    public boolean isAllowedOnBooks(){
        return true;
    }


}
