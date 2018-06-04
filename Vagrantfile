Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"
 
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
  end

  config.vm.provision "shell", inline: <<-SHELL
    add-apt-repository ppa:webupd8team/java
    apt-get update
    
    echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections 
    echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections

    apt-get install -y oracle-java8-installer
    update-alternatives --config java

    apt-get install -y git

    mkdir projects
    cd projects
    git clone https://github.com/sebgul/cognifide-library
    cd cognifide-library
    ./mvnw spring-boot:run -Dspring-boot.run.arguments=/data/books.json
  SHELL
end
