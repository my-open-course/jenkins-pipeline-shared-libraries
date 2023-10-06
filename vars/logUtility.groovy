/**
 * 日志库，需要安装 Jenkins 插件 AnsiColor
 * <br>
 * 文档：
 * <br>
 * <a href="https://plugins.jenkins.io/ansicolor/">https://plugins.jenkins.io/ansicolor/</a>
 * <br>
 * <a href="https://misc.flogisoft.com/bash/tip_colors_and_formatting">https://misc.flogisoft.com/bash/tip_colors_and_formatting</a>
 * @author LDC
 */

def call(String message, String level) {
    printMsg(message, level)
}

def printMsg(String message, String level) {
    levels = [
            'info' : "\033[0;39m [INF] - >>>>>> ${message} <<<<<< \033[0m",
            'debug': "\033[0;32m [DEB] - >>>>>> ${message} <<<<<< \033[0m",
            'warn' : "\033[0;33m [WAR] - >>>>>> ${message} <<<<<< \033[0m",
            'error': "\033[0;91m [ERR] - >>>>>> ${message} <<<<<< \033[0m",
    ]
    ansiColor('xterm') {
        println(levels[level])
    }
}

def saveBuildLog(String logPath = 'jenkins-build-log.txt') {
    writeFile file: "${logPath}", text: currentBuild.rawBuild.log
}
