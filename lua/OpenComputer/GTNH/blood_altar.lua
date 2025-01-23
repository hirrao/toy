local component = require("component")
local sides = require("sides")
local os = require("os")

local sideInput = sides.west
local sideOutput = sides.east
local sideAlter = sides.south
local transposer = component.transposer
local altar = component.blood_altar

local bloodTable = {
    ["dreamcraft:item.ArcaneSlate"] = 1000,
    ["AWWayofTime:blankSlate"] = 2500,
    ["IC2:itemCellEmpty"] = 1000,
    ["AWWayofTime:reinforcedSlate"] = 7500
}

local function getItemFromSide(side)
    return transposer.getStackInSlot(side, 1)
end

local function craftItem(num, blood)
    if (altar.getCurrentBlood() < blood) then
        print("血量不足, 结束")
        os.exit(-1)
    end
    transposer.transferItem(sideInput, sideAlter, num, 1)
    local craftingItem = getItemFromSide(sideAlter)
    print("合成中: " .. craftingItem.name)
    while true do
        os.sleep(0.5)
        if getItemFromSide(sideAlter).name ~= craftingItem.name then
            print("合成完成")
            transposer.transferItem(sideAlter, sideOutput, num, 1)
            return
        end
    end
end

local function main()
    while true do
        local inputItem = getItemFromSide(sideInput)
        if (inputItem ==nil or bloodTable[inputItem.name] == nil) then
            print("未找到可用物品, 结束")
            return
        end
        craftItem(1, bloodTable[inputItem.name])
    end
end

main()
