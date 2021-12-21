package me.exeos.utils;

import me.exeos.interfaces.MinecraftInterface;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public final class RotationUtil implements MinecraftInterface {

    public static float[] getRotations(EntityLivingBase target) {
        float yaw, pitch;
        Vec3 targetPos = new Vec3(target.posX, target.posY, target.posZ);
        Vec3 playerPos = new Vec3(mc.thePlayer.posX, mc.thePlayer.posY + mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ);
        double d0 = targetPos.xCoord - playerPos.xCoord;
        double d1 = targetPos.yCoord - playerPos.yCoord;
        double d2 = targetPos.zCoord - playerPos.zCoord;
        double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        float f = (float)(MathHelper.func_181159_b(d2, d0) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float)(-(MathHelper.func_181159_b(d1, d3) * 180.0D / Math.PI));
        yaw = f;
        pitch = f1;
        return new float[] {yaw, pitch};
    }

}
