package com.dreammaster.scripts;

import static com.dreammaster.scripts.BooleanModLoaded.*;
import static com.dreammaster.tinkersConstruct.SmelteryFluidTypes.getMoltenPatternFluidTypeName;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.recipe.RecipeCategories.alloySmelterMolding;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.brewingRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTModHandler.RecipeBits.BITS_STD;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.tinkersConstruct.SmelteryFluidTypes;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.FluidType;

public class ScriptCoreMod implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Core Mod";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AdvancedSolarPanel.ID,
                AppliedEnergistics2.ID,
                BuildCraftSilicon.ID,
                EnderIO.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                GalaxySpace.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                ProjectRedCore.ID,
                Railcraft.ID,
                RemoteIO.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Avaritia.ID, "Dire_Crafting", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(Avaritia.ID, "Triple_Craft", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "waferAdvanced",
                getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing),
                "waferAdvanced",
                ItemList.Electric_Piston_HV.get(1L),
                "circuitElite",
                ItemList.Electric_Piston_HV.get(1L));
        addShapedRecipe(NHItemList.SandStoneRod.get(), "craftingToolFile", "sandstone", "craftingToolSaw");
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                "craftingToolFile",
                "cobblestone",
                "craftingToolSaw");
        addShapedRecipe(NHItemList.LongObsidianRod.get(2), "craftingToolSaw", "stoneObsidian", "craftingToolFile");
        addShapedRecipe(NHItemList.LongStoneRod.get(2), "craftingToolSaw", "stone", "craftingToolFile");
        addShapedRecipe(
                NHItemList.MushroomPowder.get(),
                "listAllmushroom",
                null,
                null,
                "craftingToolMortar",
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                NHItemList.Display.get(),
                "platePlastic",
                ItemList.Cover_Screen.get(1L),
                "platePlastic",
                "circuitBasic",
                "cableGt01Tin",
                "circuitBasic",
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                NHItemList.LaserEmitter.get(),
                "itemCasingTitanium",
                "lensRuby",
                "itemCasingTitanium",
                getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing),
                ItemList.Emitter_HV.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced");
        addShapedRecipe(
                NHItemList.DiamondDrillTip.get(),
                "plateDiamond",
                "plateSteel",
                "plateDiamond",
                "plateDiamond",
                "plateSteel",
                "plateDiamond",
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel");
        addShapedRecipe(
                NHItemList.ReinforcedIridiumDrillTip.get(),
                "plateAlloyIridium",
                "plateSteel",
                "plateAlloyIridium",
                "plateAlloyIridium",
                "plateSteel",
                "plateAlloyIridium",
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel");
        GTModHandler.addCraftingRecipe(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1L),
                BITS_STD,
                new Object[] { "h", // craftingToolHardHammer
                        "X", "X", 'X', GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L) });
        addShapedRecipe(
                NHItemList.SawBladeDiamond.get(),
                "plateDiamond",
                "plateDiamond",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeStone.get(),
                "plateStone",
                "plateStone",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeArdite.get(),
                "plateArdite",
                "plateArdite",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeManyullyn.get(),
                "plateManyullyn",
                "plateManyullyn",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeRuby.get(),
                "plateRuby",
                "plateRuby",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeSapphire.get(),
                "plateSapphire",
                "plateSapphire",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladePeridot.get(),
                "plateOlivine",
                "plateOlivine",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.BowFletchingCast.get(),
                null,
                null,
                "craftingToolHardHammer",
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                "craftingToolKnife",
                null,
                null,
                "craftingToolFile");
        addShapedRecipe(
                NHItemList.BowFletchingCast.get(),
                null,
                null,
                "craftingToolHardHammer",
                null,
                "plateBrass",
                "craftingToolKnife",
                null,
                null,
                "craftingToolFile");
        addShapedRecipe(
                NHItemList.BowStringCast.get(),
                null,
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "craftingToolKnife");
        addShapedRecipe(
                NHItemList.BowStringCast.get(),
                null,
                null,
                null,
                null,
                "plateBrass",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                null,
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L),
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brick, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Arsenic, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Silver, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.CobaltBrass, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                NHItemList.RawSDHCAlloy.get(),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel",
                getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.CompressedCoal", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1, 0, missing),
                "screwStainlessSteel",
                "craftingToolHardHammer",
                "screwStainlessSteel");
        addShapedRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "OvenGlove", 1, 0, "{Durability:1000}", missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapelessRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "OvenGlove", 1, 0, "{Durability:1000}", missing),
                new ItemStack(NHItemList.OvenGlove.item, 1, 0),
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "OvenGlove", 1, 1, "{Durability:1000}", missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapelessRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "OvenGlove", 1, 1, "{Durability:1000}", missing),
                new ItemStack(NHItemList.OvenGlove.item, 1, 1),
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                BlockList.DiamondFrameBox.get(),
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "craftingToolWrench",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond");
        GTModHandler.addSmeltingRecipe(NHItemList.UnfiredCokeOvenBrick.get(), NHItemList.CokeOvenBrick.get());
        if (TCML) {
            addShapedRecipe(
                    NHItemList.MoldFormCoinage.get(),
                    null,
                    null,
                    null,
                    null,
                    getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                    null,
                    "craftingToolFile",
                    "craftingToolWireCutter",
                    null);
            TConstructHelper.getMeltingAdder(FluidType.getFluidType(getMoltenPatternFluidTypeName()), 150, 72)
                    .add(
                            Stream.of(
                                    NHItemList.ShapeBolt,
                                    NHItemList.ShapeHoeHead,
                                    NHItemList.ShapeGear,
                                    NHItemList.ShapePlate,
                                    NHItemList.MoldFormAnvil,
                                    NHItemList.MoldFormPlate,
                                    NHItemList.MoldFormLeggings,
                                    NHItemList.MoldFormBaguette,
                                    NHItemList.MoldFormGear,
                                    NHItemList.MoldFormRotor,
                                    NHItemList.ShapeBottle,
                                    NHItemList.ShapeRotor,
                                    NHItemList.ShapeTurbineBlade,
                                    NHItemList.ShapeSmallGear,
                                    NHItemList.MoldFormBoots,
                                    NHItemList.ShapeLargePipe,
                                    NHItemList.MoldFormSmallGear,
                                    NHItemList.MoldFormCasing,
                                    NHItemList.MoldFormChestplate,
                                    NHItemList.ShapeShovelHead,
                                    NHItemList.MoldFormBread,
                                    NHItemList.ShapeIngot,
                                    NHItemList.MoldFormIngot,
                                    NHItemList.ShapeFileHead,
                                    NHItemList.ShapeRod,
                                    NHItemList.ShapeHugePipe,
                                    NHItemList.ShapeSwordBlade,
                                    NHItemList.ShapeRing,
                                    NHItemList.ShapeCasing,
                                    NHItemList.MoldFormNuggets,
                                    NHItemList.ShapeSmallPipe,
                                    NHItemList.MoldFormName,
                                    NHItemList.ShapeHammerHead,
                                    NHItemList.ShapeTinyPipe,
                                    NHItemList.MoldFormCylinder,
                                    NHItemList.MoldFormBottle,
                                    NHItemList.ShapeAxeHead,
                                    NHItemList.ShapeSawBlade,
                                    NHItemList.MoldFormBlock,
                                    NHItemList.ShapeCell,
                                    NHItemList.MoldFormArrowHead,
                                    NHItemList.ShapeBoat,
                                    NHItemList.MoldFormCoinage,
                                    NHItemList.MoldFormBall,
                                    NHItemList.ShapeBlock,
                                    NHItemList.MoldFormHelmet,
                                    NHItemList.ShapePickaxeHead,
                                    NHItemList.MoldFormBuns,
                                    NHItemList.ShapeNormalPipe,
                                    NHItemList.MoldFormStick,
                                    NHItemList.MoldFormStickLong,
                                    NHItemList.MoldFormScrew,
                                    NHItemList.MoldFormRing,
                                    NHItemList.MoldFormBolt,
                                    NHItemList.MoldFormRound,
                                    NHItemList.MoldFormTurbineBlade,
                                    NHItemList.MoldFormPipeTiny,
                                    NHItemList.MoldFormPipeSmall,
                                    NHItemList.MoldFormPipeMedium,
                                    NHItemList.MoldFormPipeLarge,
                                    NHItemList.MoldFormPipeHuge).map(NHItemList::get))
                    .add(NHItemList.MarshmallowFormMold.get());
        }

        GTValues.RA.stdBuilder().itemInputs(ItemList.CokeOvenCasing.get(1)).itemOutputs(NHItemList.CokeOvenBrick.get(4))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 12, missing))
                .itemOutputs(NHItemList.AdvancedCokeOvenBrick.get(4)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 500),
                getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                NHItemList.EngineCore.get(),
                "abc",
                "def",
                "ghi",
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                'e',
                getModItem(Minecraft.ID, "piston", 1, 0, missing));

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBoat.get(1))
                .itemOutputs(NHItemList.ExtruderShapeBoat.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeAxeHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Axe.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapePickaxeHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pickaxe.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeShovelHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Shovel.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSwordBlade.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Sword.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHoeHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Hoe.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHammerHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Hammer.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeFileHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_File.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSawBlade.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Saw.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeGear.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Gear.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSmallGear.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Small_Gear.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRotor.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Rotor.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeTurbineBlade.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Turbine_Blade.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeDrillHead.get(1))
                .itemOutputs(ItemList.Shape_Extruder_ToolHeadDrill.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapePlate.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Plate.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeCell.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Cell.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRing.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Ring.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRod.get(1)).itemOutputs(ItemList.Shape_Extruder_Rod.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBolt.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Bolt.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeIngot.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Ingot.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeCasing.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Casing.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBlock.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Block.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBottle.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Bottle.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeTinyPipe.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Tiny.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSmallPipe.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Small.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeNormalPipe.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Medium.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeLargePipe.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Large.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHugePipe.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Huge.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeWire.get(1))
                .itemOutputs(ItemList.Shape_Extruder_Wire.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBottle.get(1))
                .itemOutputs(ItemList.Shape_Mold_Bottle.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPlate.get(1))
                .itemOutputs(ItemList.Shape_Mold_Plate.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormIngot.get(1))
                .itemOutputs(ItemList.Shape_Mold_Ingot.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCasing.get(1))
                .itemOutputs(ItemList.Shape_Mold_Casing.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormGear.get(1)).itemOutputs(ItemList.Shape_Mold_Gear.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormSmallGear.get(1))
                .itemOutputs(ItemList.Shape_Mold_Gear_Small.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCoinage.get(1))
                .itemOutputs(ItemList.Shape_Mold_Credit.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormNuggets.get(1))
                .itemOutputs(ItemList.Shape_Mold_Nugget.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBlock.get(1))
                .itemOutputs(ItemList.Shape_Mold_Block.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBall.get(1)).itemOutputs(ItemList.Shape_Mold_Ball.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBuns.get(1)).itemOutputs(ItemList.Shape_Mold_Bun.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBread.get(1))
                .itemOutputs(ItemList.Shape_Mold_Bread.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBaguette.get(1))
                .itemOutputs(ItemList.Shape_Mold_Baguette.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCylinder.get(1))
                .itemOutputs(ItemList.Shape_Mold_Cylinder.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormAnvil.get(1))
                .itemOutputs(ItemList.Shape_Mold_Anvil.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormArrowHead.get(1))
                .itemOutputs(ItemList.Shape_Mold_Arrow.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormName.get(1)).itemOutputs(ItemList.Shape_Mold_Name.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBolt.get(1)).itemOutputs(ItemList.Shape_Mold_Bolt.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRound.get(1))
                .itemOutputs(ItemList.Shape_Mold_Round.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormScrew.get(1))
                .itemOutputs(ItemList.Shape_Mold_Screw.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRing.get(1)).itemOutputs(ItemList.Shape_Mold_Ring.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormStick.get(1)).itemOutputs(ItemList.Shape_Mold_Rod.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormStickLong.get(1))
                .itemOutputs(ItemList.Shape_Mold_Rod_Long.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRotor.get(1))
                .itemOutputs(ItemList.Shape_Mold_Rotor.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormTurbineBlade.get(1))
                .itemOutputs(ItemList.Shape_Mold_Turbine_Blade.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        // Pipes
        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeTiny.get(1))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Tiny.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeSmall.get(1))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Small.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeMedium.get(1))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Medium.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeLarge.get(1))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Large.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeHuge.get(1))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Huge.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormDrillHead.get(1))
                .itemOutputs(ItemList.Shape_Mold_ToolHeadDrill.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormHelmet.get(1)).itemOutputs(NHItemList.MoldHelmet.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormChestplate.get(1))
                .itemOutputs(NHItemList.MoldChestplate.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormLeggings.get(1))
                .itemOutputs(NHItemList.MoldLeggings.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                .duration(4000 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBoots.get(1)).itemOutputs(NHItemList.MoldBoots.get(1))
                .fluidInputs(Materials.Steel.getMolten(576L)).duration(4000 * TICKS).eut(16)
                .addTo(fluidSolidifierRecipes);

        // Center slot MUST stay casing (index 4).
        // Indexes: 0 1 2 / 3 4 5 / 6 7 8

        // --------------------
        // MOLD FORMS (generic)
        // --------------------

        addShapedRecipe(
                NHItemList.MoldFormArrowHead.get(),
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBaguette.get(),
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBall.get(),
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBlock.get(),
                null,
                "craftingToolFile",
                null,
                null,
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBolt.get(),
                null,
                null,
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                "craftingToolFile",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBottle.get(),
                null,
                null,
                null,
                "craftingToolFile",
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBread.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolFile");

        addShapedRecipe(
                NHItemList.MoldFormBuns.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolFile",
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.MoldFormCasing.get(),
                "craftingToolWrench",
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormCoinage.get(),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormCylinder.get(),
                "craftingToolHardHammer",
                null,
                "craftingToolScrewdriver",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormGear.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                "craftingToolWrench",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormIngot.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                "craftingToolFile",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormName.get(),
                "craftingToolFile",
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.MoldFormNuggets.get(),
                null,
                "craftingToolFile",
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormPlate.get(),
                "craftingToolHardHammer",
                "craftingToolFile",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormRing.get(),
                null,
                "craftingToolHardHammer",
                "craftingToolFile",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormRound.get(),
                "craftingToolFile",
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormRotor.get(),
                null,
                null,
                null,
                "craftingToolWrench",
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormScrew.get(),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormSmallGear.get(),
                null,
                null,
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                "craftingToolWrench",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormStick.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolHardHammer",
                "craftingToolFile");

        addShapedRecipe(
                NHItemList.MoldFormStickLong.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                "craftingToolFile",
                null);

        addShapedRecipe(
                NHItemList.MoldFormTurbineBlade.get(),
                "craftingToolWrench",
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.MoldFormPipeTiny.get(),
                "craftingToolHardHammer",
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolFile",
                null);

        addShapedRecipe(
                NHItemList.MoldFormPipeSmall.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolFile",
                null);

        addShapedRecipe(
                NHItemList.MoldFormPipeMedium.get(),
                null,
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolFile",
                null);

        addShapedRecipe(
                NHItemList.MoldFormPipeLarge.get(),
                null,
                "craftingToolFile",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolHardHammer",
                null);

        addShapedRecipe(
                NHItemList.MoldFormPipeHuge.get(),
                null,
                "craftingToolFile",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.MoldFormDrillHead.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolWrench");

        addShapedRecipe(
                NHItemList.MoldFormAnvil.get(),
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolWrench",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        // --------------------
        // ARMOR MOLD FORMS
        // --------------------

        addShapedRecipe(
                NHItemList.MoldFormHelmet.get(),
                "craftingToolHardHammer",
                null,
                "craftingToolScrewdriver",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormChestplate.get(),
                "craftingToolHardHammer",
                null,
                "craftingToolWrench",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormLeggings.get(),
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldFormBoots.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                "craftingToolScrewdriver",
                null,
                null,
                null);

        // --------------------
        // MOLDS (final molds)
        // (crafted similarly; distinct tool layouts)
        // --------------------

        addShapedRecipe(
                NHItemList.MoldHelmet.get(),
                null,
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldChestplate.get(),
                null,
                "craftingToolWrench",
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldLeggings.get(),
                null,
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.MoldBoots.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                "craftingToolFile",
                null);

        // --------------------
        // SHAPES
        // --------------------

        addShapedRecipe(
                NHItemList.ShapePlate.get(),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeIngot.get(),
                "craftingToolHardHammer",
                "craftingToolWireCutter",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeRod.get(),
                null,
                "craftingToolHardHammer",
                "craftingToolWireCutter",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeRing.get(),
                "craftingToolWireCutter",
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeBolt.get(),
                null,
                null,
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                "craftingToolWireCutter",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeCell.get(),
                null,
                "craftingToolWireCutter",
                null,
                null,
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeBottle.get(),
                null,
                null,
                "craftingToolFile",
                null,
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeBlock.get(),
                "craftingToolHardHammer",
                null,
                "craftingToolWrench",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeCasing.get(),
                "craftingToolWrench",
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeGear.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                "craftingToolBranchCutter",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeSmallGear.get(),
                null,
                null,
                null,
                "craftingToolWrench",
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeRotor.get(),
                null,
                null,
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                "craftingToolBranchCutter",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeTurbineBlade.get(),
                "craftingToolWrench",
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.ShapeWire.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolHardHammer",
                "craftingToolFile");

        addShapedRecipe(
                NHItemList.ShapeTinyPipe.get(),
                "craftingToolHardHammer",
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolWireCutter",
                null);

        addShapedRecipe(
                NHItemList.ShapeSmallPipe.get(),
                null,
                "craftingToolHardHammer",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolBranchCutter",
                null);

        addShapedRecipe(
                NHItemList.ShapeNormalPipe.get(),
                null,
                null,
                "craftingToolHardHammer",
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolBranchCutter",
                null);

        addShapedRecipe(
                NHItemList.ShapeLargePipe.get(),
                null,
                "craftingToolBranchCutter",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                "craftingToolHardHammer",
                null);

        addShapedRecipe(
                NHItemList.ShapeHugePipe.get(),
                null,
                "craftingToolBranchCutter",
                null,
                null,
                "itemCasingBrass",
                null,
                null,
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.ShapeSwordBlade.get(),
                "craftingToolHardHammer",
                null,
                null,
                null,
                "itemCasingBrass",
                "craftingToolFile",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapePickaxeHead.get(),
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeShovelHead.get(),
                null,
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                "itemCasingBrass",
                null,
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeAxeHead.get(),
                "craftingToolFile",
                null,
                null,
                null,
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeHoeHead.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolFile");

        addShapedRecipe(
                NHItemList.ShapeHammerHead.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                "craftingToolWrench",
                null);

        addShapedRecipe(
                NHItemList.ShapeFileHead.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolFile",
                null,
                "craftingToolHardHammer");

        addShapedRecipe(
                NHItemList.ShapeSawBlade.get(),
                null,
                null,
                null,
                "craftingToolSaw",
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeBoat.get(),
                "craftingToolSaw",
                null,
                null,
                null,
                "itemCasingBrass",
                "craftingToolHardHammer",
                null,
                null,
                null);

        addShapedRecipe(
                NHItemList.ShapeDrillHead.get(),
                null,
                null,
                null,
                null,
                "itemCasingBrass",
                null,
                "craftingToolHardHammer",
                null,
                "craftingToolBranchCutter");

        if (TCML) {
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.ExtruderShapeBoat.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.ShapeBoat.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.MoldBoots.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.MoldFormBoots.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.MoldChestplate.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.MoldFormChestplate.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.MoldHelmet.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.MoldFormHelmet.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.MoldLeggings.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.MoldFormLeggings.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.MarshmallowForm.get(),
                    FluidRegistry.getFluidStack("steel.molten", 576),
                    NHItemList.MarshmallowFormMold.get(),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.BowFletchingCast.get(),
                    FluidRegistry.getFluidStack(SmelteryFluidTypes.getMoltenPatternFluidName(), 144),
                    getModItem(TinkerConstruct.ID, "fletching", 1, wildcard, missing),
                    true,
                    100);
            TConstructRegistry.getTableCasting().addCastingRecipe(
                    NHItemList.BowStringCast.get(),
                    FluidRegistry.getFluidStack(SmelteryFluidTypes.getMoltenPatternFluidName(), 144),
                    getModItem(TinkerConstruct.ID, "bowstring", 1, wildcard, missing),
                    true,
                    100);
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 6L))
                .itemOutputs(BlockList.BronzePlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L))
                .itemOutputs(BlockList.SteelPlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 6L))
                .itemOutputs(BlockList.TitaniumPlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.platinum", 144)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L))
                .itemOutputs(BlockList.TungstensteelPlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.iridium", 144)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 6L))
                .itemOutputs(BlockList.NaquadahPlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.osmium", 144)).duration(22 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6L))
                .itemOutputs(BlockList.NeutroniumPlatedReinforcedStone.get())
                .fluidInputs(FluidRegistry.getFluidStack("molten.naquadria", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTOreDictUnificator.addItemData(
                BlockList.BronzePlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.Bronze, 6 * GTValues.M),
                        new ItemData(Materials.Steel, 3 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.SteelPlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.Steel, 8 * GTValues.M),
                        new ItemData(Materials.Aluminium, 1 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.TitaniumPlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.Titanium, 6 * GTValues.M),
                        new ItemData(Materials.Platinum, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.TungstensteelPlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.TungstenSteel, 6 * GTValues.M),
                        new ItemData(Materials.Iridium, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.NaquadahPlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.Naquadah, 6 * GTValues.M),
                        new ItemData(Materials.Osmium, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.NeutroniumPlatedReinforcedStone.get(),
                new ItemData(
                        new ItemData(Materials.Neutronium, 6 * GTValues.M),
                        new ItemData(Materials.Naquadria, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 6, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 14, missing))
                .itemOutputs(NHItemList.LightBinding.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawBioFiber.get(2)).circuit(2)
                .itemOutputs(NHItemList.BioOrganicMesh.get()).duration(40 * SECONDS).eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1L),
                        NHItemList.CompressedBioBall.get(8))
                .itemOutputs(NHItemList.BioChunk.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_MV / 2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L))
                .circuit(4).itemOutputs(BlockList.DiamondFrameBox.get()).duration(3 * SECONDS + 4 * TICKS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L))
                .itemOutputs(BlockList.CompressedGraphite.get(2)).duration(5 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing))
                .itemOutputs(NHItemList.BlankPlatedChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.PulsatingSpatialCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorSpatialPulsatingCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.DiamondFluidCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorFluidDiamondCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldAdvancedFluidCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorFluidEmeraldCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        NHItemList.GoldCoreChip.get())
                .itemOutputs(NHItemList.LogicProcessorItemGoldCore.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.DiamondCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorItemDiamondCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldAdvancedCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorItemEmeraldCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldHighAdvancedCoreChip.get())
                .itemOutputs(NHItemList.EngineeringProcessorItemAdvEmeraldCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3, missing),
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 6, missing))
                .itemOutputs(NHItemList.LeadNickelPlate.get(2))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 2000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .itemOutputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 288)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.get()).outputChances(3300)
                .fluidInputs(FluidRegistry.getFluidStack("ic2biomass", 8)).duration(10 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.get()).outputChances(5000)
                .fluidInputs(FluidRegistry.getFluidStack("methanol", 8)).duration(7 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.get()).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 8)).duration(5 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.get()).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("nitrofuel", 8)).duration(2 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get(2))
                .fluidInputs(FluidRegistry.getFluidStack("water", 288)).duration(1 * MINUTES).eut(TierEU.RECIPE_HV / 2)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get(2))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 160)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_HV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get(2))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 64)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get(2))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(10)).duration(12 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 75)).duration(2 * MINUTES).eut(2)
                .addTo(fermentingRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(NHItemList.EngravedDiamondCrystalChip.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.EngravedEnergyChip.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Jasper, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.EngravedEnergyChip.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Spinel, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.EngravedEnergyChip.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetRed, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.EngravedEnergyChip.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedFire, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.EngravedEnergyChip.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedAir, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(NHItemList.EngravedQuantumChip.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_LuV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Force, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(NHItemList.EngravedQuantumChip.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_LuV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetYellow, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(NHItemList.EngravedQuantumChip.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_LuV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.NanoCrystal.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.NanoCrystal.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.QuantumCrystal.get()).duration(40 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(NHItemList.QuantumCrystal.get()).duration(40 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 4))
                .itemOutputs(NHItemList.ManyullynCrystal.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 4))
                .itemOutputs(NHItemList.ManyullynCrystal.get()).duration(1 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        NHItemList.ManyullynCrystal.get())
                .itemOutputs(NHItemList.EngravedManyullynCrystalChip.get()).duration(45 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        NHItemList.ManyullynCrystal.get())
                .itemOutputs(NHItemList.EngravedManyullynCrystalChip.get()).duration(45 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Dilithium, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedOrder, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().circuit(3).fluidInputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 10))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 1)).duration(3 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(distilleryRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Shape_Extruder_Casing.get(0L))
                .itemOutputs(NHItemList.IridiumAlloyItemCasing.get(2)).duration(20 * SECONDS).eut(384)
                .addTo(extruderRecipes);
        if (TML) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "materials", 2, 4, missing),
                            ItemList.Shape_Extruder_Saw.get(0L))
                    .itemOutputs(NHItemList.SawBladeArdite.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "materials", 2, 5, missing),
                            ItemList.Shape_Extruder_Saw.get(0L))
                    .itemOutputs(NHItemList.SawBladeManyullyn.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                            ItemList.Shape_Extruder_Plate.get(0L))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 1))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(Minecraft.ID, "feather", 1, 0, missing), NHItemList.BowFletchingCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                            NHItemList.BowFletchingCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 2, missing)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "materials", 1, 17, missing),
                            NHItemList.BowFletchingCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 3, missing)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(Minecraft.ID, "leaves", 1, 0, missing), NHItemList.BowFletchingCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 1, missing)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "slime.leaves", 1, 0, missing),
                            NHItemList.BowFletchingCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 4, missing)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(Minecraft.ID, "string", 3, 0, missing), NHItemList.BowStringCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 0, missing)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            if (NML) {
                GTValues.RA.stdBuilder()
                        .itemInputs(getModItem(Natura.ID, "barleyFood", 3, 7, missing), NHItemList.BowStringCast.get(0))
                        .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 2, missing)).duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
            }
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Thaumcraft.ID, "ItemResource", 3, 7, missing),
                            NHItemList.BowStringCast.get(0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 1, missing)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedManyullynCrystalChip.get(),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(NHItemList.PulsatingSpatialCoreChip.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.DiamondFluidCoreChip.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldAdvancedFluidCoreChip.get()).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedGoldChip.get(),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing))
                .itemOutputs(NHItemList.GoldCoreChip.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedDiamondCrystalChip.get(),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.DiamondCoreChip.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedEnergyChip.get(),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldAdvancedCoreChip.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedQuantumChip.get(),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldHighAdvancedCoreChip.get()).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV / 2).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(NHItemList.GeneticCircuit.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.EnvironmentalCircuit.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.AluminiumIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.TitaniumIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.TungstenIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.TungstenSteelIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.ChromeIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.NaquadriaIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.NeutroniumIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(NHItemList.BedrockiumIronPlate.get()).duration(30 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone", 1, 0, missing))
                .itemOutputs(NHItemList.LongStoneRod.get(4)).duration(16 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sandstone", 1, wildcard, missing))
                .itemOutputs(NHItemList.SandStoneRod.get()).duration(8 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cobblestone", 1, 0, missing))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Stone, 2L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "mushroom", 1, wildcard, missing))
                .itemOutputs(NHItemList.MushroomPowder.get(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "brown_mushroom", 1, 0, missing))
                .itemOutputs(NHItemList.MushroomPowder.get(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        if (BOPML) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, wildcard, missing))
                    .itemOutputs(NHItemList.MushroomPowder.get(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                    .addTo(maceratorRecipes);
        }
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "whitemushroomItem", 1, 0, missing))
                .itemOutputs(NHItemList.MushroomPowder.get(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.IridiumAlloyItemCasing.get())
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 8L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.MysteriousCrystal.get())
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawMytryl.get())
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 55, missing))
                .itemOutputs(NHItemList.ElectrotineWire.get(2)).duration(5 * SECONDS).eut(4).addTo(wiremillRecipes);

        // Obsidian Stuff
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(NHItemList.LongObsidianRod.get(2)).duration(32 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(Materials.Lubricant.getFluid(5)).duration(11 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(Materials.Water.getFluid(20)).duration(22 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(GTModHandler.getDistilledWater(15)).duration(22 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .fluidOutputs(Materials.Obsidian.getMolten(288)).duration(10 * SECONDS + 16 * TICKS).eut(35)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2))
                .duration(9 * SECONDS + 18 * TICKS).eut(4).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian), ItemList.Shape_Mold_Ingot.get(0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2))
                .duration(6 * SECONDS + 10 * TICKS).eut(3).recipeCategory(alloySmelterMolding)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GTValues.RA.stdBuilder().fluidInputs(Materials.Obsidian.getMolten(288))
                .itemInputs(ItemList.Shape_Mold_Block.get(0)).itemOutputs(new ItemStack(Blocks.obsidian))
                .duration(14 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_ULV).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2),
                        ItemList.Shape_Extruder_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(10 * TICKS).eut(24).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2),
                        ItemList.Shape_Extruder_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(10 * TICKS).eut(24).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2),
                        ItemList.Shape_Mold_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(5 * TICKS).eut(12)
                .recipeCategory(alloySmelterMolding).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2),
                        ItemList.Shape_Mold_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(5 * TICKS).eut(12)
                .recipeCategory(alloySmelterMolding).addTo(alloySmelterRecipes);

    }
}
