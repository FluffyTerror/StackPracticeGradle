pipeline {
    agent any

    parameters {
        choice(name: 'CUCUMBER_TAGS', choices: [
            '@UI',
            '@Deposits',
            '@Career',
            '@Cards',
            '@Credits'
        ], description: 'Выберите Cucumber теги')
    }

    stages {
        stage('Run Tests') {
            steps {
                echo "Выбранные теги: ${params.CUCUMBER_TAGS}"
                bat "gradlew clean test -Dcucumber.filter.tags=\"${params.CUCUMBER_TAGS}\""
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/build/reports/**', allowEmptyArchive: true
        }
    }
}
