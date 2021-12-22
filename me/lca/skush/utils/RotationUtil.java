package me.lca.skush.utils;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.BlockData;
import me.lca.skush.interfaces.MinecraftInterface;
import me.lca.skush.module.impl.world.Scaffold;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.Random;

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
        //GCD FIX
        final float f2 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
        final float f3 = f2 * f2 * f2 * 1.2F;
        f -= (f % f3);
        f1 -=(f1 % (f3 * f2));
        yaw = f;
        pitch = f1;
        return new float[] {yaw, pitch};
    }
    public static float[] Intavee(final EntityPlayerSP player, final EntityLivingBase target) {
        final float RotationPitch = (float) MathHelper.getRandomDoubleInRange(new Random(), 90, 92);
        final float RotationYaw = (float) MathHelper.getRandomDoubleInRange(new Random(), RotationPitch, 94);
        final double posX = target.posX - player.posX;
        final float RotationY2 = (float) MathHelper.getRandomDoubleInRange(new Random(), 175, 180);
        final float RotationY4 = (float) MathHelper.getRandomDoubleInRange(new Random(), 0.2, 0.3);
        final float RotationY3 = (float) MathHelper.getRandomDoubleInRange(new Random(), RotationY4, 0.1);
        final double posY = target.posY + target.getEyeHeight()
                - (player.posY + player.getAge() + player.getEyeHeight() + RotationY3);
        final double posZ = target.posZ - player.posZ;
        final double var14 = MathHelper.sqrt_double(posX * posX + posZ * posZ);
        float yaw = (float) (Math.atan2(posZ, posX) * RotationY2 / Math.PI) - RotationYaw;
        float pitch = (float) -(Math.atan2(posY, var14) * RotationY2 / Math.PI);
        final float f2 = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
        final float f3 = f2 * f2 * f2 * 1.2F;
        yaw -= yaw % f3;
        pitch -= pitch % (f3 * f2);
        // return new float[]{yaw, MathHelper.clamp_float(pitch, -90, 90)};
        return new float[] { yaw, pitch };
    }
}
