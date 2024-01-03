# 将字幕文件文件名修改为视频文件相同的文件名
# 便于播放器自动加载字幕
# 可能对OVA无法识别，具体未测试
import os
import glob
import logging


# 将字幕文件重命名为与视频文件相同名称
def replace_filename_mkv_ass(paths):
    mkv_files = glob.glob('*.mkv')
    logging.info(f"mkv文件列表 {str(mkv_files)}")
    ass_files = sorted(glob.glob('*.ass'))
    logging.info(f"字幕文件列表 {str(ass_files)}")
    if len(mkv_files) == 0 or len(ass_files) == 0:
        logging.error(f"不存在这样的文件")
        return

    names = mkv_files[0].split("[01]")
    video_prefix = names[0]
    video_suffix = names[1].split(".mkv")[0]
    logging.info(f"文件前缀为 {video_prefix}")
    logging.info(f"文件后缀为 {video_suffix}")
    n = 1
    for filename in ass_files:
        num = f"{n:02d}"
        new_filename = f"{video_prefix}[{num}]{video_suffix}.chs.ass"
        os.rename(os.path.join(paths, filename), os.path.join(paths, new_filename))
        n = n + 1
        logging.info(f"重命名 {filename}为{new_filename}")


if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    paths = os.getcwd()
    logging.info(f"当前路径为 {paths}")
    replace_filename_mkv_ass(paths)
    logging.info("重命名完成，按任意键退出")
    input()
