package com.ashley.tutorial.block.blocks;

import com.ashley.tutorial.TutorialMod;
import com.ashley.tutorial.block.entity.TutorialBlockEntities;
import com.ashley.tutorial.block.entity.entities.ClayOvenBlockEntity;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ClayOvenBlock extends BlockWithEntity {

    public ClayOvenBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new ClayOvenBlockEntity();
    }

    // new stuff
    // A side effect of extending BlockWithEntity is it changes the render type to INVISIBLE, so we have to revert this


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ClayOvenBlockEntity) {
//                ContainerProviderRegistry.INSTANCE.openContainer(TutorialBlockEntities.CLAY_OVEN, player, buf -> buf.writeBlockPos(pos));
                ContainerProviderRegistry.INSTANCE.openContainer(new Identifier("tutorial","clay_oven"), player, buf -> buf.writeBlockPos(pos));

            }
        }
        return ActionResult.SUCCESS;
    }

    // Scatter the items in the chest when it is removed.
    @Override
    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ClayOvenBlockEntity) {
                ItemScatterer.spawn(world, (BlockPos)pos, (Inventory)((ClayOvenBlockEntity)blockEntity));
                // update comparators
                world.updateHorizontalAdjacent(pos, this);
            }
            super.onBlockRemoved(state, world, pos, newState, moved);
        }
    }
}

