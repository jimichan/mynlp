
description = "自动依赖必要的资源"

dependencies {

    api("org.jetbrains.kotlin:kotlin-stdlib")

    api(project(":mynlp"))

    // 核心词典
    implementation("com.mayabot.mynlp.resource:mynlp-resource-coredict:1.0.0")
    // 词性标注
    implementation("com.mayabot.mynlp.resource:mynlp-resource-pos:1.0.0")
    // 命名实体
    implementation("com.mayabot.mynlp.resource:mynlp-resource-ner:1.0.0")
    // pinyin
    implementation("com.mayabot.mynlp.resource:mynlp-resource-pinyin:1.1.0")
    // 繁简体转换
    implementation("com.mayabot.mynlp.resource:mynlp-resource-transform:1.0.2")


    // 感知机分词模型
//   implementation 'com.mayabot.mynlp.resource:mynlp-resource-cws:1.0.0'

    // 自定义扩展词库
//   implementation 'com.mayabot.mynlp.resource:mynlp-resource-custom:1.0.0'
}