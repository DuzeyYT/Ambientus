package me.lca.skush.module.impl.world;

import com.google.common.eventbus.Subscribe;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.BlockData;
import me.lca.skush.event.impl.EventPreMotion;
import me.lca.skush.event.impl.EventPreUpdate;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import me.lca.skush.utils.RotationUtil;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.*;

@ModuleInterface(name = "Scaffold", displayName = "Scaffold", description = "Will automatically Sprint", category = Category.Movement, color = 0xFFbc78cf)
public class Scaffold extends Module {
    public static float yaw, pitch;
    public static BlockData data;
    @Subscribe
    public void onUpdate(EventUpdate e) {
        mc.thePlayer.setSprinting(false);
        data = find(new Vec3(0, 0, 0));
        if (this.data != null) {
            BlockPos blockPos = new BlockPos(mc.getMinecraft().thePlayer.posX, mc.getMinecraft().thePlayer.posY - 1,
                    mc.getMinecraft().thePlayer.posZ);
            if (mc.theWorld.getBlockState(blockPos).getBlock() == Blocks.air) {
                mc.rightClickMouse();
            }
        }
    }
    @Subscribe
    @SuppressWarnings("unused")
    public void onPreUpdate(EventPreUpdate e) {
        float[] rotation = rotationrecode7(this.data);
        yaw = mc.thePlayer.rotationYaw + 180;
        pitch = rotation[1];
        mc.thePlayer.rotationYawHead = yaw;
        mc.thePlayer.renderYawOffset = yaw;
        mc.thePlayer.rotationPitchHead = rotation[1];
        e.setRotation(new float[] {yaw, pitch});
    }
    @Override
    public void onDisable() {
        super.onDisable();
    }
    @Override
    public void onEnable() {
        super.onEnable();
    }

    private Vec3 getPositionByFace(BlockPos position, EnumFacing facing) {
        Vec3 offset = new Vec3((double) facing.getDirectionVec().getX() / 2.0,
                (double) facing.getDirectionVec().getY() / 2.0, (double) facing.getDirectionVec().getZ() / 2.0);
        Vec3 point = new Vec3((double) position.getX() + 0.5, (double) position.getY() + 0.5,
                (double) position.getZ() + 0.5);
        return point.add(offset);
    }

    private boolean rayTrace(Vec3 origin, Vec3 position) {
        Vec3 difference = position.subtract(origin);
        int steps = 10;
        double x = difference.xCoord / (double) steps;
        double y = difference.yCoord / (double) steps;
        double z = difference.zCoord / (double) steps;
        Vec3 point = origin;
        for (int i = 0; i < steps; ++i) {
            BlockPos blockPosition = new BlockPos(point = point.addVector(x, y, z));
            IBlockState blockState = mc.getMinecraft().theWorld.getBlockState(blockPosition);
            if (blockState.getBlock() instanceof BlockLiquid || blockState.getBlock() instanceof BlockAir)
                continue;
            AxisAlignedBB boundingBox = blockState.getBlock().getCollisionBoundingBox(mc.getMinecraft().theWorld,
                    blockPosition, blockState);
            if (boundingBox == null) {
                boundingBox = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            }
            if (!boundingBox.offset(blockPosition.getX(), blockPosition.getY(), blockPosition.getZ())
                    .isVecInside(point))
                continue;
            return true;
        }
        return false;
    }

    private BlockData find(Vec3 offset3) {

        double x = mc.getMinecraft().thePlayer.posX;
        double y = mc.getMinecraft().thePlayer.posY;
        double z = mc.getMinecraft().thePlayer.posZ;

        EnumFacing[] invert = new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.SOUTH, EnumFacing.NORTH,
                EnumFacing.EAST, EnumFacing.WEST };
        BlockPos position = new BlockPos(new Vec3(x, y, z).add(offset3)).offset(EnumFacing.DOWN);
        for (EnumFacing facing : EnumFacing.values()) {
            BlockPos offset = position.offset(facing);
            if (mc.getMinecraft().theWorld.getBlockState(offset).getBlock() instanceof BlockAir || rayTrace(
                    mc.getMinecraft().thePlayer.getLook(0.0f), getPositionByFace(offset, invert[facing.ordinal()])))
                continue;
            return new BlockData(invert[facing.ordinal()], offset);
        }
        BlockPos[] offsets = new BlockPos[] { new BlockPos(-1, 0, 0), new BlockPos(1, 0, 0), new BlockPos(0, 0, -1),
                new BlockPos(0, 0, 1), new BlockPos(0, 0, 2), new BlockPos(0, 0, -2), new BlockPos(2, 0, 0),
                new BlockPos(-2, 0, 0) };
        for (BlockPos offset : offsets) {
            BlockPos offsetPos = position.add(offset.getX(), 0, offset.getZ());
            if (!(mc.getMinecraft().theWorld.getBlockState(offsetPos).getBlock() instanceof BlockAir))
                continue;
            for (EnumFacing facing : EnumFacing.values()) {
                BlockPos offset2 = offsetPos.offset(facing);
                if (mc.getMinecraft().theWorld.getBlockState(offset2).getBlock() instanceof BlockAir
                        || rayTrace(mc.getMinecraft().thePlayer.getLook(0.01f),
                        getPositionByFace(offset, invert[facing.ordinal()])))
                    continue;
                return new BlockData(invert[facing.ordinal()], offset2);
            }
        }
        return null;
    }


    public static class BlockData {
        private static EnumFacing facing;

        private static BlockPos pos;

        public BlockData(EnumFacing facing, BlockPos pos) {
            BlockData.facing = facing;
            BlockData.pos = pos;
        }

        public static EnumFacing getFacing() {
            return facing;
        }

        public static BlockPos getPos() {
            return pos;
        }
    }
    public static float[] rotationrecode7(BlockData blockData) {
        double x = blockData.getPos().getX() + 0.5D - mc.thePlayer.posX + blockData.getFacing().getFrontOffsetX() / 2.0D;
        double z = blockData.getPos().getZ() + 0.5D - mc.thePlayer.posZ + blockData.getFacing().getFrontOffsetZ() / 2.0D;
        double y = blockData.getPos().getY() + 0.6D;
        double ymax = mc.thePlayer.posY + mc.thePlayer.getEyeHeight() - y;
        double allmax = MathHelper.sqrt_double(x * x + z * z);
        float yaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
        float pitch = (float) (Math.atan2(ymax, allmax) * 180.0D / Math.PI);
        //GCD
        final float f2 = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6F + 0.2F;
        final float f3 = f2 * f2 * f2 * 1.2F;
        yaw -= yaw % f3;
        pitch -= pitch % (f3 * f2);
        return new float[]{yaw, MathHelper.clamp_float(pitch, 75, 80)};
    }
}