package com.ashley.tutorial.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FlourBlock extends Block {
    public static final BooleanProperty WET = BooleanProperty.of("wet");

    public FlourBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(WET, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = blockView.getBlockState(blockPos);
        return isWater(blockState) || waterOnAnySide(blockView, blockPos) ? getDefaultState().with(WET,true) : getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(WET);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.setBlockState(pos, state.with(WET, !state.get(WET)));
        return ActionResult.SUCCESS;
    }
    private static boolean waterOnAnySide(BlockView view, BlockPos pos) {
        boolean bl = false;
        BlockPos.Mutable mutable = new BlockPos.Mutable(pos);
        Direction[] var4 = Direction.values();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Direction direction = var4[var6];
            BlockState blockState = view.getBlockState(mutable);
            if (direction != Direction.DOWN || isWater(blockState)) {
                mutable.set(pos).setOffset(direction);
                blockState = view.getBlockState(mutable);
                if (isWater(blockState) && !blockState.isSideSolidFullSquare(view, pos, direction.getOpposite())) {
                    bl = true;
                    break;
                }
            }
        }

        return bl;
    }
    private static boolean isWater(BlockState state) {
        return state.getFluidState().matches(FluidTags.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
        return waterOnAnySide(world, pos) ? state.with(WET, true) : super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
    }
}
