pipelineJob('rcv-build-coolest-game')
{
    def git_repository = 'https://' + System.getenv('git_token') + '@github.com/lmashraf/coolest-game.git'

    description("Pipeline to run Release Candidate Verification pipeline for Coolest Game Project")

    definition
    {
        cpsScm {
            scm {
                git {
                    remote { url(git_repository) }
                    scriptPath('./Jenkinsfile')
                    branch('*/master')
                    // Prevents tagging the repo
                    extensions {}
                }
            }
        }
    }
}