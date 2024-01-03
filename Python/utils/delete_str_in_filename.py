# 用于删除文件指定字符串
# 本意是EPUB的格式工具
import os
import logging


def delete_str_in_filename(paths, texts=""):
    if texts == "":
        texts = input("输入删除的字符串\n")
    for filename in os.listdir(paths):
        if texts in filename:
            newname = filename.replace(texts, '')
            os.rename(os.path.join(paths, filename), os.path.join(paths, newname))
            logging.info(f"{filename}修改为{newname}")


if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    path = os.getcwd()
    text = input("输入删除的字符串\n")
    logging.info(f"当前路径为 {path}")
    logging.info(f"删除的字符串为 {text}")
    delete_str_in_filename(path, text)
    logging.info("修改完成，按任意键退出")
    input("")
