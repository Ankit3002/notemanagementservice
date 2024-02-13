#!  /usr/bin/bash
#!/bin/bash

# Function to get the IP address
get_ip_address() {
    ifconfig_output=$(ifconfig wlp1s0)
    ip_address=$(echo "$ifconfig_output" | grep -o 'inet[^ ]*' | awk '{print $2}')
    echo "$ip_address"
}

# Function to update server.address in application-dev.properties
update_server_address() {
    ip_address=$1
    sed -i "s/\(server.address=\).*/\1$ip_address/" src/main/resources/application-dev.properties
}

# Get the IP address
ip_address=$(get_ip_address)

# Update server.address in application-dev.properties
update_server_address "$ip_address"

echo "Updated server.address to $ip_address in application-dev.properties with ip as $ip_address" 



mvn clean package
java -jar ./target/notemanagementservice-0.0.1-SNAPSHOT.jar
