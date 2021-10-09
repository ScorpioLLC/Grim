package ac.grim.grimac.utils.chunkdata.eight;

import ac.grim.grimac.utils.blockstate.BaseBlockState;
import ac.grim.grimac.utils.blockstate.MagicBlockState;
import ac.grim.grimac.utils.chunkdata.BaseChunk;

public class EightChunk implements BaseChunk {
    private final ShortArray3d blocks;

    public EightChunk() {
        blocks = new ShortArray3d(4096);
    }

    public EightChunk(ShortArray3d blocks) {
        this.blocks = blocks;
    }

    @Override
    public void set(int x, int y, int z, int combinedID) {
        // Usual system for storing combined ID's: F (data) F (empty) FF FF (material ID)
        // 1.8 system for storing combined ID's: F (empty) FF FF (material id) F (data)
        blocks.set(x, y, z, combinedID);
    }

    @Override
    public BaseBlockState get(int x, int y, int z) {
        int data = blocks.get(x, y, z);
        return new MagicBlockState(data >> 4, data & 0xF);
    }

    // This method only works post-flattening
    // This is due to the palette system
    @Override
    public boolean isKnownEmpty() {
        return false;
    }

    public ShortArray3d getBlocks() {
        return blocks;
    }
}
