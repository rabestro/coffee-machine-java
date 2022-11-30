runner {
    filterStackTrace true

    parallel {
        enabled true
    }
}

report {
    issueNamePrefix 'Issue #'
    issueUrlPrefix 'https://github.com/rabestro/coffee-machine-java/issues/'
}

spockReports {
    // If set to true, hides blocks which do not have any description
    set 'com.athaydes.spockframework.report.hideEmptyBlocks': false
    // options are: "class_name_and_title", "class_name", "title"
    set 'com.athaydes.spockframework.report.internal.HtmlReportCreator.specSummaryNameOption': title
    // exclude Specs Table of Contents
    set 'com.athaydes.spockframework.report.internal.HtmlReportCreator.excludeToc':false
    // Show the source code for each block
    set 'com.athaydes.spockframework.report.showCodeBlocks': false
    set 'com.athaydes.spockframework.report.outputDir': 'build/reports/tests'
    set 'com.athaydes.spockframework.report.projectName': 'Coffee Machine'
    set 'com.athaydes.spockframework.report.projectVersion': 1.0
}

