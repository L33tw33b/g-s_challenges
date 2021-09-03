from pytube import YouTube
import sys

def main():
    args = sys.argv[1:]
    if len(args) > 0:
        DEFAULT_SAVE_DIR = "C:/Users/ronal/Desktop"
        yt = YouTube(args[0])
        stream = yt.streams.get_by_itag(139)
        stream.download(DEFAULT_SAVE_DIR,yt.title+".mp3")

if __name__ == "__main__":
    main()
